import React, { useState } from 'react';
import { View, Text, StyleSheet, Button, TextInput, ScrollView, TouchableOpacity, Alert, ActivityIndicator } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import { RootStackParamList } from '../navigation/AppNavigator';
import { Picker } from '@react-native-picker/picker';
import DateTimePicker from '@react-native-community/datetimepicker';

type Props = NativeStackScreenProps<RootStackParamList, 'AddPlayer'>;

const roles = [
  { label: 'Batsman', value: 'BATSMAN' },
  { label: 'Bowler', value: 'BOWLER' },
  { label: 'All-Rounder', value: 'ALL_ROUNDER' },
  { label: 'Wicket-Keeper', value: 'WICKET_KEEPER' },
];

const AddPlayerScreen: React.FC<Props> = ({ navigation }) => {
  const [firstName, setFirstName] = useState('');
  const [middleName, setMiddleName] = useState('');
  const [lastName, setLastName] = useState('');
  const [dateOfBirth, setDateOfBirth] = useState('dd/mm/yyyy');
  const [showDatePicker, setShowDatePicker] = useState(false);
  const [nationality, setNationality] = useState('');
  const [role, setRole] = useState(roles[0].value);
  const [battingStyle, setBattingStyle] = useState('');
  const [bowlingStyle, setBowlingStyle] = useState('');
  const [loading, setLoading] = useState(false);

  const handleCreate = async () => {
    setLoading(true);
    try {
      // Convert dd/mm/yyyy to yyyy-mm-dd
      const [dd, mm, yyyy] = dateOfBirth.split('/');
      const dobISO = `${yyyy}-${mm.padStart(2, '0')}-${dd.padStart(2, '0')}`;
      const response = await fetch('http://localhost:8080/api/players', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          firstName,
          middleName,
          lastName,
          dateOfBirth: dobISO,
          nationality,
          role,
          battingStyle,
          bowlingStyle,
          teams: [] // Teams integration coming soon
        })
      });
      if (!response.ok) throw new Error('Failed to create player');
      Alert.alert('Success', 'Player created successfully');
      navigation.navigate('PlayerList');
    } catch (err: any) {
      Alert.alert('Error', err.message || 'Failed to create player');
    } finally {
      setLoading(false);
    }
  };

  return (
    <ScrollView contentContainerStyle={styles.container}>
      <Text style={styles.title}>Create Player</Text>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>First Name</Text>
        <TextInput style={styles.input} value={firstName} onChangeText={setFirstName} />
      </View>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>Middle Name</Text>
        <TextInput style={styles.input} value={middleName} onChangeText={setMiddleName} />
      </View>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>Last Name</Text>
        <TextInput style={styles.input} value={lastName} onChangeText={setLastName} />
      </View>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>Date of Birth</Text>
        <TextInput
          style={styles.input}
          value={dateOfBirth}
          onChangeText={setDateOfBirth}
          placeholder="dd/mm/yyyy"
          keyboardType="default"
        />
      </View>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>Nationality</Text>
        <TextInput style={styles.input} value={nationality} onChangeText={setNationality} />
      </View>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>Role</Text>
        <View style={styles.pickerContainer}>
          <Picker selectedValue={role} onValueChange={setRole} style={styles.picker}>
            {roles.map(r => <Picker.Item key={r.value} label={r.label} value={r.value} />)}
          </Picker>
        </View>
      </View>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>Batting Style</Text>
        <TextInput style={styles.input} value={battingStyle} onChangeText={setBattingStyle} />
      </View>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>Bowling Style</Text>
        <TextInput style={styles.input} value={bowlingStyle} onChangeText={setBowlingStyle} />
      </View>
      <View style={styles.fieldGroup}>
        <Text style={styles.label}>Teams</Text>
        <View style={styles.teamsPlaceholder}>
          <Text style={{ color: '#888' }}>(multi-select coming soon)</Text>
        </View>
      </View>
      <View style={styles.buttonRow}>
        <Button title="Create" onPress={handleCreate} disabled={loading} />
        <Button title="Cancel" onPress={() => navigation.navigate('PlayerList')} color="#888" disabled={loading} />
      </View>
      {loading && <ActivityIndicator size="large" color="#007AFF" style={{ marginTop: 10 }} />}
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: { flexGrow: 1, justifyContent: 'center', alignItems: 'center', backgroundColor: '#fff', padding: 20 },
  title: { fontSize: 22, fontWeight: 'bold', marginBottom: 20 },
  fieldGroup: { width: '100%', maxWidth: 400, marginBottom: 12 },
  label: { fontSize: 15, color: '#333', marginBottom: 4, marginLeft: 2 },
  input: { backgroundColor: '#F5F5F5', padding: 12, borderRadius: 8, fontSize: 16 },
  pickerContainer: { backgroundColor: '#F5F5F5', borderRadius: 8 },
  picker: { width: '100%' },
  teamsPlaceholder: { marginTop: 4, marginBottom: 4 },
  buttonRow: { flexDirection: 'row', gap: 20, marginTop: 20, marginBottom: 40, justifyContent: 'center' },
});

export default AddPlayerScreen; 
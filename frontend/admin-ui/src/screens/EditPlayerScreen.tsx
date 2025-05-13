import React from 'react';
import { View, Text, StyleSheet, Button } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import { RootStackParamList } from '../navigation/AppNavigator';

type Props = NativeStackScreenProps<RootStackParamList, 'EditPlayer'>;

const EditPlayerScreen: React.FC<Props> = ({ navigation }) => (
  <View style={styles.container}>
    <Text style={styles.text}>Edit Player Screen (Coming Soon)</Text>
    <View style={styles.buttonRow}>
      <Button title="Update" onPress={() => navigation.navigate('PlayerList')} />
      <Button title="Cancel" onPress={() => navigation.navigate('PlayerList')} color="#888" />
    </View>
  </View>
);

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor: '#fff' },
  text: { fontSize: 20, color: '#888', marginBottom: 40 },
  buttonRow: { flexDirection: 'row', gap: 20 },
});

export default EditPlayerScreen; 
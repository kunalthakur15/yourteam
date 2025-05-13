import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, StyleSheet, TouchableOpacity, TextInput, ActivityIndicator, Alert } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import { RootStackParamList } from '../navigation/AppNavigator';
import { Ionicons } from '@expo/vector-icons';

// Type for navigation props
type Props = NativeStackScreenProps<RootStackParamList, 'PlayerList'>;

type Player = {
  id: string;
  firstName: string;
  middleName?: string;
  lastName: string;
  role: string;
  team?: string;
};

const PlayerListScreen: React.FC<Props> = ({ navigation }) => {
  const [players, setPlayers] = useState<Player[]>([]);
  const [loading, setLoading] = useState(false);
  const [search, setSearch] = useState('');

  const fetchPlayers = async () => {
    setLoading(true);
    try {
      const response = await fetch('http://localhost:8080/api/players');
      if (!response.ok) throw new Error('Failed to fetch players');
      const data = await response.json();
      setPlayers(data);
    } catch (err: any) {
      Alert.alert('Error', err.message || 'Failed to fetch players');
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchPlayers();
  }, []);

  const handleAddPlayer = () => {
    navigation.navigate('AddPlayer');
  };

  const handleEditPlayer = (playerId: string) => {
    navigation.navigate('EditPlayer', { playerId });
  };

  const renderItem = ({ item }: { item: Player }) => (
    <TouchableOpacity
      style={styles.card}
      onLongPress={() => handleEditPlayer(item.id)}
      activeOpacity={0.8}
    >
      <Text style={styles.playerName}>{item.firstName} {item.lastName}</Text>
      <Text style={styles.playerInfo}>{item.role}</Text>
    </TouchableOpacity>
  );

  return (
    <View style={styles.container}>
      {/* Search and Filter */}
      <View style={styles.topBar}>
        <TextInput
          style={styles.search}
          placeholder="Search player by name"
          value={search}
          onChangeText={setSearch}
        />
        <TouchableOpacity style={styles.filterIcon}>
          <Ionicons name="filter" size={24} color="#007AFF" />
        </TouchableOpacity>
      </View>
      {/* Player List */}
      {loading ? (
        <ActivityIndicator size="large" color="#007AFF" style={{ marginTop: 40 }} />
      ) : (
        <FlatList
          data={players.filter(p => (`${p.firstName} ${p.lastName}`.toLowerCase().includes(search.toLowerCase())))}
          renderItem={renderItem}
          keyExtractor={item => item.id}
          contentContainerStyle={styles.listContent}
        />
      )}
      {/* Floating Add Button */}
      <TouchableOpacity style={styles.fab} onPress={handleAddPlayer}>
        <Ionicons name="add" size={32} color="#fff" />
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#fff' },
  topBar: { flexDirection: 'row', alignItems: 'center', padding: 10 },
  search: { flex: 1, backgroundColor: '#F5F5F5', borderRadius: 8, padding: 10, fontSize: 16 },
  filterIcon: { marginLeft: 10 },
  listContent: { padding: 10 },
  card: { backgroundColor: '#f0f0f0', borderRadius: 8, padding: 16, marginBottom: 12 },
  playerName: { fontSize: 18, fontWeight: 'bold', color: '#333' },
  playerInfo: { fontSize: 14, color: '#666', marginTop: 4 },
  fab: { position: 'absolute', right: 24, bottom: 24, backgroundColor: '#007AFF', borderRadius: 32, width: 56, height: 56, alignItems: 'center', justifyContent: 'center', elevation: 4 },
});

export default PlayerListScreen; 
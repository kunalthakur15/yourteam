import React from 'react';
import { View, Button, StyleSheet } from 'react-native';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import { RootStackParamList } from '../navigation/AppNavigator';

// Type for navigation props
type Props = NativeStackScreenProps<RootStackParamList, 'Menu'>;

const MenuScreen: React.FC<Props> = ({ navigation }) => {
  return (
    <View style={styles.container}>
      <Button title="Tournament" onPress={() => {}} />
      <Button title="Player" onPress={() => navigation.navigate('PlayerList')} />
      <Button title="Team" onPress={() => {}} />
      <Button title="Match" onPress={() => {}} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    gap: 20,
    backgroundColor: '#fff',
  },
});

export default MenuScreen; 
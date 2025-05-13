import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import SplashScreen from '../screens/SplashScreen';
import LoginScreen from '../screens/LoginScreen';
import MenuScreen from '../screens/MenuScreen';
import PlayerListScreen from '../screens/PlayerListScreen';
import AddPlayerScreen from '../screens/AddPlayerScreen';
import EditPlayerScreen from '../screens/EditPlayerScreen';

export type RootStackParamList = {
  Splash: undefined;
  Login: undefined;
  Menu: undefined;
  PlayerList: undefined;
  AddPlayer: undefined;
  EditPlayer: { playerId: string } | undefined;
};

const Stack = createNativeStackNavigator<RootStackParamList>();

const AppNavigator = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator
        initialRouteName="Splash"
        screenOptions={{
          headerShown: false,
        }}
      >
        <Stack.Screen name="Splash" component={SplashScreen} />
        <Stack.Screen name="Login" component={LoginScreen} />
        <Stack.Screen name="Menu" component={MenuScreen} options={{ title: 'Admin Menu' }} />
        <Stack.Screen name="PlayerList" component={PlayerListScreen} options={{ title: 'Players' }} />
        <Stack.Screen name="AddPlayer" component={AddPlayerScreen} options={{ title: 'Add Player' }} />
        <Stack.Screen name="EditPlayer" component={EditPlayerScreen} options={{ title: 'Edit Player' }} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default AppNavigator; 
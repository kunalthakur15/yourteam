import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  TextInput,
  TouchableOpacity,
  StyleSheet,
  Alert,
  Platform,
  Image,
} from 'react-native';
import { useNavigation } from '@react-navigation/native';
import { NativeStackNavigationProp } from '@react-navigation/native-stack';
import { RootStackParamList } from '../navigation/AppNavigator';
import { FontAwesome, FontAwesome5 } from '@expo/vector-icons';

const YELLOW = '#FFBB00';
const GRAY = '#222222';

const LoginScreen = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigation = useNavigation<NativeStackNavigationProp<RootStackParamList, 'Login'>>();

  useEffect(() => {
    if (Platform.OS === 'web' && typeof window !== 'undefined' && window.sessionStorage.getItem('isLoggedIn') === 'true') {
      navigation.replace('Menu');
    }
  }, [navigation]);

  const handleLogin = () => {
    if (email === 'admin' && password === 'admin') {
      if (Platform.OS === 'web' && typeof window !== 'undefined') {
        window.sessionStorage.setItem('isLoggedIn', 'true');
      }
      navigation.replace('Menu');
    } else {
      Alert.alert('Login Failed', 'Invalid username or password');
    }
  };

  return (
    <View style={styles.container}>
      {/* Logo */}
      <View style={styles.logoCircle}>
        <Image
          source={require('../../assets/icon.png')}
          style={{ width: 56, height: 56 }}
          resizeMode="contain"
        />
      </View>
      {/* Heading */}
      <Text style={styles.title}>Sign In</Text>
      {/* Inputs */}
      <View style={styles.inputContainer}>
        <View style={styles.inputWrapper}>
          <TextInput
            style={styles.input}
            placeholder="Username"
            value={email}
            onChangeText={setEmail}
            autoCapitalize="none"
            placeholderTextColor="#888"
          />
          <View style={styles.inputUnderline} />
        </View>
        <View style={styles.inputWrapper}>
          <TextInput
            style={styles.input}
            placeholder="Password"
            value={password}
            onChangeText={setPassword}
            secureTextEntry
            placeholderTextColor="#888"
          />
          <View style={styles.inputUnderline} />
        </View>
        <TouchableOpacity style={styles.button} onPress={handleLogin}>
          <Text style={styles.buttonText}>Login</Text>
        </TouchableOpacity>
      </View>
      <Text style={styles.terms}>By signing in you are agreeing to our Terms & Policies</Text>
      {/* Social login */}
      <View style={styles.socialRow}>
        <View style={styles.socialCircle}>
          <FontAwesome name="facebook" size={28} color="#fff" />
        </View>
        <View style={styles.socialCircle}>
          <FontAwesome name="twitter" size={28} color="#fff" />
        </View>
        <View style={styles.socialCircle}>
          <FontAwesome name="google" size={28} color="#fff" />
        </View>
      </View>
      <View style={{ flex: 1 }} />
      <Text style={styles.signupText}>
        Don't have an account?{' '}
        <Text style={styles.signupLink} onPress={() => {}}>
          Sign Up
        </Text>
      </Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    paddingHorizontal: 24,
    paddingTop: 60,
    paddingBottom: 24,
  },
  logoCircle: {
    width: 100,
    height: 100,
    borderRadius: 50,
    backgroundColor: YELLOW,
    alignItems: 'center',
    justifyContent: 'center',
    marginBottom: 40,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: GRAY,
    marginBottom: 24,
    alignSelf: 'center',
  },
  inputContainer: {
    width: '100%',
    maxWidth: 400,
    marginBottom: 18,
  },
  inputWrapper: {
    marginBottom: 24,
  },
  input: {
    fontSize: 15,
    color: GRAY,
    paddingVertical: 8,
    paddingHorizontal: 0,
    backgroundColor: 'transparent',
  },
  inputUnderline: {
    height: 2,
    backgroundColor: YELLOW,
    width: '100%',
    marginTop: -2,
  },
  button: {
    backgroundColor: GRAY,
    borderRadius: 12,
    paddingVertical: 16,
    alignItems: 'center',
    marginTop: 8,
    marginBottom: 12,
  },
  buttonText: {
    color: YELLOW,
    fontSize: 16,
    fontWeight: 'bold',
  },
  terms: {
    color: '#888',
    fontSize: 11,
    marginBottom: 24,
    textAlign: 'center',
  },
  socialRow: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 24,
    gap: 24,
  },
  socialCircle: {
    width: 44,
    height: 44,
    borderRadius: 22,
    backgroundColor: YELLOW,
    alignItems: 'center',
    justifyContent: 'center',
    marginHorizontal: 8,
  },
  signupText: {
    color: GRAY,
    fontSize: 13,
    marginTop: 12,
    marginBottom: 8,
    textAlign: 'center',
  },
  signupLink: {
    color: GRAY,
    fontWeight: 'bold',
    textDecorationLine: 'underline',
  },
});

export default LoginScreen; 
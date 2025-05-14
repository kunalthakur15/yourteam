import React, { useState } from 'react';
import { View, Text, TouchableOpacity, StyleSheet, ScrollView, Platform } from 'react-native';
import { MaterialCommunityIcons, FontAwesome5, Feather } from '@expo/vector-icons';
import { useNavigation } from '@react-navigation/native';
import type { NativeStackNavigationProp } from '@react-navigation/native-stack';
import type { RootStackParamList } from '../navigation/AppNavigator';

const YELLOW = '#FFBB00';
const CARD_BG = '#222222';
const ICON_BG = '#5A3E16';

const menuItems = [
  { title: 'Tournaments', icon: <FontAwesome5 name="trophy" size={28} color={YELLOW} />, desc: 'Manage cricket tournaments and series', stats: '5 active', nav: null },
  { title: 'Teams', icon: <MaterialCommunityIcons name="account-group" size={28} color={YELLOW} />, desc: 'Manage cricket teams and franchises', stats: '24 teams', nav: null },
  { title: 'Players', icon: <Feather name="users" size={28} color={YELLOW} />, desc: 'Manage player profiles and statistics', stats: '450 players', nav: 'PlayerList' },
  { title: 'Matches', icon: <Feather name="calendar" size={28} color={YELLOW} />, desc: 'Schedule and manage cricket matches', stats: '12 upcoming', nav: null },
  { title: 'Rules', icon: <Feather name="file-text" size={28} color={YELLOW} />, desc: 'Define fantasy scoring rules and regulations', stats: '', nav: null },
  { title: 'Leagues', icon: <Feather name="list" size={28} color={YELLOW} />, desc: 'Manage fantasy leagues and contests', stats: '8 leagues', nav: null },
];

const quickStats = [
  { label: 'Total Users', value: '24,521', change: '+5.2%' },
  { label: 'Active Contests', value: '43', change: '+12.5%' },
  { label: 'Teams Created', value: '18,302', change: '+3.8%' },
  { label: 'Revenue', value: '$12,845', change: '+8.3%' },
];

const recentActivity = [
  { icon: <FontAwesome5 name="trophy" size={18} color={YELLOW} />, text: "Tournament 'IPL 2023' created", time: '2h ago' },
  { icon: <Feather name="users" size={18} color={YELLOW} />, text: "Updated player stats for 'England vs Australia'", time: '5h ago' },
  { icon: <Feather name="calendar" size={18} color={YELLOW} />, text: "New match scheduled: 'India vs Pakistan'", time: '8h ago' },
  { icon: <Feather name="file-text" size={18} color={YELLOW} />, text: "League 'World Cup Fantasy' rules updated", time: '1d ago' },
];

const MenuScreen = () => {
  const navigation = useNavigation<NativeStackNavigationProp<RootStackParamList>>();
  const [pressedIdx, setPressedIdx] = useState<number | null>(null);
  const [hoveredIdx, setHoveredIdx] = useState<number | null>(null);
  return (
    <ScrollView style={styles.bg} contentContainerStyle={{ padding: 20 }}>
      {/* Header */}
      <View style={styles.headerRow}>
        <View style={styles.headerIcon}>
          <FontAwesome5 name="layer-group" size={24} color="#fff" />
        </View>
        <Text style={styles.headerText}>Cricket Fantasy Admin</Text>
        <View style={{ flex: 1 }} />
        <TouchableOpacity
          style={styles.logoutBtn}
          onPress={() => {
            if (Platform.OS === 'web' && typeof window !== 'undefined') {
              window.sessionStorage.removeItem('isLoggedIn');
            }
            navigation.replace('Login');
          }}
          {...(Platform.OS === 'web' ? { className: 'logout-web-btn' } : {})}
        >
          <Text style={styles.logoutBtnText}>Logout</Text>
        </TouchableOpacity>
      </View>
      <Text style={styles.subHeader}>Control Center</Text>

      {/* Menu Cards: 3 columns, 2 rows */}
      <View style={styles.grid3x2}>
        {menuItems.map((item, idx) => {
          const isActive = pressedIdx === idx;
          const isHovered = hoveredIdx === idx;
          const webTransition =
            Platform.OS === 'web'
              ? { transition: 'transform 0.25s cubic-bezier(0.4,0.2,0.2,1), box-shadow 0.25s cubic-bezier(0.4,0.2,0.2,1)' }
              : {};
          return (
            <View
              key={idx}
              style={[
                styles.card,
                isActive && styles.cardActive,
                Platform.OS === 'web' && isHovered ? styles.cardHover : null,
              ]}
              {...(Platform.OS === 'web'
                ? {
                    className: isHovered ? 'card-web-transition card-web-hover' : 'card-web-transition',
                    onMouseEnter: () => setHoveredIdx(idx),
                    onMouseLeave: () => setHoveredIdx(null),
                  }
                : {})}
            >
              <TouchableOpacity
                onPress={() => item.nav && navigation.navigate('PlayerList')}
                activeOpacity={0.85}
                onPressIn={() => setPressedIdx(idx)}
                onPressOut={() => setPressedIdx(null)}
                style={{ width: '100%' }}
              >
                <View style={styles.cardIcon}>{item.icon}</View>
                <View style={styles.cardTextBlock}>
                  <Text style={styles.cardTitle}>{item.title}</Text>
                  <Text style={styles.cardDesc}>{item.desc}</Text>
                  <View style={styles.cardDivider} />
                  {item.stats ? <Text style={styles.cardStats}>{item.stats}</Text> : null}
                </View>
              </TouchableOpacity>
            </View>
          );
        })}
      </View>

      {/* Quick Stats & Recent Activity */}
      <View style={styles.row}>
        {/* Quick Stats */}
        <View style={styles.statsCard}>
          <View style={styles.statsHeader}>
            <Text style={styles.statsTitle}>Quick Stats</Text>
            <Feather name="bar-chart-2" size={20} color={YELLOW} />
          </View>
          <View style={styles.statsGrid}>
            {quickStats.map((stat, idx) => (
              <View key={idx} style={styles.statBox}>
                <Text style={styles.statLabel}>{stat.label}</Text>
                <Text style={styles.statValue}>{stat.value}</Text>
                <View style={styles.statChangeRow}>
                  <Feather name="trending-up" size={12} color={YELLOW} />
                  <Text style={styles.statChange}>{stat.change}</Text>
                </View>
              </View>
            ))}
          </View>
        </View>
        {/* Recent Activity */}
        <View style={styles.activityCard}>
          <View style={styles.statsHeader}>
            <Text style={styles.statsTitle}>Recent Activity</Text>
            <Text style={styles.activityToday}>Today</Text>
          </View>
          {recentActivity.map((act, idx) => (
            <View key={idx} style={styles.activityItem}>
              <View style={styles.activityIcon}>{act.icon}</View>
              <Text style={styles.activityText}>{act.text}</Text>
              <Text style={styles.activityTime}>{act.time}</Text>
            </View>
          ))}
        </View>
      </View>

      {/* Upgrade Banner */}
      <View style={styles.upgradeCard}>
        <View>
          <Text style={styles.upgradeTitle}>Ready to boost your fantasy league?</Text>
          <Text style={styles.upgradeDesc}>Upgrade to Pro for advanced analytics and management tools.</Text>
        </View>
        <TouchableOpacity style={styles.upgradeBtn}>
          <Text style={styles.upgradeBtnText}>Upgrade to Pro</Text>
        </TouchableOpacity>
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  bg: {
    flex: 1,
    backgroundColor: '#F3F4F6',
  },
  headerRow: { flexDirection: 'row', alignItems: 'center', marginTop: 10, marginBottom: 4 },
  headerIcon: { backgroundColor: YELLOW, borderRadius: 20, padding: 8, marginRight: 10 },
  headerText: { color: '#222', fontSize: 28, fontWeight: 'bold' },
  subHeader: { color: '#666', fontSize: 16, marginBottom: 18 },
  grid3x2: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-between',
    marginBottom: 24,
  },
  card: {
    backgroundColor: CARD_BG,
    borderRadius: 16,
    paddingVertical: 24,
    paddingHorizontal: 20,
    width: '32%',
    marginBottom: 18,
    shadowColor: YELLOW,
    shadowOffset: { width: 0, height: 4 },
    shadowOpacity: 0.12,
    shadowRadius: 8,
    elevation: 4,
    borderWidth: 2,
    borderColor: 'transparent',
    alignItems: 'flex-start',
    justifyContent: 'flex-start',
  },
  cardActive: {
    borderColor: YELLOW,
    shadowOpacity: 0.25,
  },
  cardHover: {
    transform: [{ translateY: -8 }],
    zIndex: 2,
    boxShadow: '0 8px 32px 0 rgba(255, 187, 0, 0.18), 0 2px 8px 0 rgba(255, 187, 0, 0.10)',
  },
  cardIcon: {
    backgroundColor: 'rgba(255,187,0,0.2)',
    borderRadius: 12,
    padding: 14,
    marginBottom: 16,
    alignItems: 'center',
    justifyContent: 'center',
    alignSelf: 'flex-start',
  },
  cardTextBlock: { width: '100%' },
  cardTitle: {
    color: '#fff',
    fontSize: 22,
    fontWeight: 'bold',
    fontFamily: 'Inter, System',
    marginBottom: 4,
  },
  cardDesc: {
    color: '#bdbdbd',
    fontSize: 15,
    fontFamily: 'Inter, System',
    marginBottom: 12,
  },
  cardDivider: {
    width: '100%',
    height: 1,
    backgroundColor: '#444',
    marginVertical: 8,
  },
  cardStats: {
    color: '#fff',
    fontWeight: 'bold',
    fontSize: 20,
    fontFamily: 'Inter, System',
  },
  row: { flexDirection: 'row', justifyContent: 'space-between', marginBottom: 24 },
  statsCard: {
    backgroundColor: CARD_BG,
    borderRadius: 16,
    padding: 16,
    flex: 2,
    marginRight: 10,
  },
  statsHeader: { flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between', marginBottom: 10 },
  statsTitle: { color: '#fff', fontSize: 20, fontWeight: 'bold' },
  statsGrid: { flexDirection: 'row', flexWrap: 'wrap', justifyContent: 'space-between' },
  statBox: {
    backgroundColor: '#333',
    borderRadius: 10,
    padding: 10,
    width: '47%',
    marginBottom: 10,
  },
  statLabel: { color: '#bbb', fontSize: 12 },
  statValue: { color: '#fff', fontSize: 20, fontWeight: 'bold' },
  statChangeRow: { flexDirection: 'row', alignItems: 'center', marginTop: 4 },
  statChange: { color: YELLOW, fontSize: 12, marginLeft: 4 },
  activityCard: {
    backgroundColor: CARD_BG,
    borderRadius: 16,
    padding: 16,
    flex: 1,
    marginLeft: 10,
  },
  activityToday: { color: YELLOW, fontSize: 12, backgroundColor: 'rgba(255,187,0,0.2)', paddingHorizontal: 8, paddingVertical: 2, borderRadius: 8 },
  activityItem: { flexDirection: 'row', alignItems: 'center', marginBottom: 12 },
  activityIcon: { backgroundColor: 'rgba(255,187,0,0.2)', borderRadius: 12, padding: 6, marginRight: 8, alignItems: 'center', justifyContent: 'center' },
  activityText: { color: '#fff', flex: 1, fontSize: 14 },
  activityTime: { color: '#bbb', fontSize: 12, marginLeft: 8 },
  upgradeCard: {
    backgroundColor: CARD_BG,
    borderRadius: 16,
    padding: 20,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginBottom: 24,
  },
  upgradeTitle: { color: '#fff', fontSize: 18, fontWeight: 'bold', marginBottom: 4 },
  upgradeDesc: { color: '#bbb', fontSize: 14, marginBottom: 8 },
  upgradeBtn: { backgroundColor: YELLOW, borderRadius: 8, paddingVertical: 10, paddingHorizontal: 18 },
  upgradeBtnText: { color: CARD_BG, fontWeight: 'bold', fontSize: 16 },
  logoutBtn: {
    paddingVertical: 8,
    paddingHorizontal: 18,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#222222',
    backgroundColor: 'transparent',
    marginLeft: 16,
    alignSelf: 'center',
  },
  logoutBtnText: {
    color: '#222222',
    fontWeight: 'bold',
    fontSize: 16,
  },
});

export default MenuScreen; 
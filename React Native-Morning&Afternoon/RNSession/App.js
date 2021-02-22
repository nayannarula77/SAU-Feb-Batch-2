import 'react-native-gesture-handler';
import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
  Button,
} from 'react-native';

import {
  Header,
  LearnMoreLinks,
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';

import Upcoming from './src/components/Upcoming';
import TopRated from './src/components/topRated';
import Popular from './src/components/Popular';
import MovieDetails from './src/components/MovieDetails';

const PopularStack = createStackNavigator();

function PopularStackScreen() {
  return (
    <PopularStack.Navigator>
      <PopularStack.Screen name="Popular" component={Popular} />
      <PopularStack.Screen name="MovieDetails" component={MovieDetails} />
    </PopularStack.Navigator>
  );
}


const UpcomingStack = createStackNavigator();

function UpcomingStackScreen() {
  return (
    <UpcomingStack.Navigator>
      <UpcomingStack.Screen name="Upcoming" component={Upcoming} />
      <UpcomingStack.Screen name="MovieDetails" component={MovieDetails} />
    </UpcomingStack.Navigator>
  );
}


const TopRatedStack = createStackNavigator();

function TopRatedStackScreen() {
  return (
    <TopRatedStack.Navigator>
      <TopRatedStack.Screen name="Top Rated" component={TopRated} />
      <TopRatedStack.Screen name="MovieDetails" component={MovieDetails} />
    </TopRatedStack.Navigator>
  );
}



const Tab = createBottomTabNavigator();


function App() {
  return (
    <NavigationContainer >
    <Tab.Navigator style={styles.container}>
    <Tab.Screen name="Upcoming" component={UpcomingStackScreen} />
      <Tab.Screen name="Top Rated" component={TopRatedStackScreen} />
      <Tab.Screen name="Popular" component={PopularStackScreen} />
    </Tab.Navigator>
  </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  
  container: {
      backgroundColor: "black"
  },
  cardTitle:{
    fontSize: 20,
      color:"white",
      fontWeight: "bold"
  }

  });



export default App;

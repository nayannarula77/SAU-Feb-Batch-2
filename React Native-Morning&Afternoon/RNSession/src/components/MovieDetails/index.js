import React, {PureComponent} from 'react';
import {Text,ScrollView, Image, StyleSheet } from 'react-native';

export default function MovieDetails({route, navigation}){
    const {title, overview, poster_path, release_date, adult, id, original_language,popularity,vote_count,vote_average } = route.params;
    return (
        <ScrollView style={styles.scrollView}>
            <Text  style={styles.cardTitle} >Title: {title}</Text>
            <Text style={styles.text}>Movie id: {id}</Text>
            <Text style={styles.text}>Release Date: {release_date}</Text>
            <Image
            style={{width:400, height:400}}
        source={{uri:'http://image.tmdb.org/t/p/original'+poster_path}}/>
            <Text style={styles.overview}>{overview}</Text>
            <Text style={styles.text}>Language: {original_language}</Text>
            <Text style={styles.text}>Popularity: {popularity}</Text>
            <Text style={styles.text}>Vote Average: {vote_average}</Text>
            <Text style={styles.text}>Vote Count: {vote_count}</Text>
            
        </ScrollView>
    )
}

const styles = StyleSheet.create({
    cardTitle: {
        fontSize: 25,
        color:"white",
        fontWeight: "bold"
      },
      scrollView: {
          backgroundColor: "black"
      },
      overview:{
        fontSize: 20,
        color:"white",
        fontStyle:"italic"
      },
      text:{
        fontSize: 20,
        color:"yellow"
      }
      });
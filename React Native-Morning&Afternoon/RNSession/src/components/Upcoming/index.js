import React, {PureComponent} from 'react';
import {Text,View, Image, FlatList, ScrollView, TouchableOpacity, StyleSheet} from 'react-native';
import { Card, ListItem, Button, Icon } from 'react-native-elements'
import GlobalStyle from '../../../src/themes/GlobalStyle';


class Upcoming extends PureComponent{

    constructor(props){
        super(props);
        this.state={
            name:"Upcoming"
        }
    }

async componentDidMount(){
    console.log("cdm");
    const res = await fetch("https://api.themoviedb.org/3/movie/upcoming?api_key=5b0847ff411e343281e0fb0279ef27a1&language=en-US&page=1").then((res)=>{
        console.log(res);
        return res.json();
    }).then(jsonData=>{
        console.log(jsonData);
        this.setState({
            data: jsonData,
        })
    });
    
}

render(){

const {data} = this.state;

return(
   
<ScrollView style={styles.container}>

    <Card >
  
  <Card.Divider/>
  {
    data?.results.map( item =>  {
      return (
        <TouchableOpacity key={item.title} onPress={() => this.props.navigation.navigate('MovieDetails',item)}>
        <View style={styles.container}>
          <Card.Image source={{uri:'http://image.tmdb.org/t/p/w500'+item.poster_path}}>
          </Card.Image>
          <Card.Title style={styles.cardTitle}>{item.title}</Card.Title>
        </View>
        <Card.Divider/>
        </TouchableOpacity>
      );
    })
  }
</Card>

</ScrollView>





)

}

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

export default Upcoming;
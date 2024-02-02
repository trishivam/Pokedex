package com.shivam.pokedex.screen.pokedexScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import java.time.format.TextStyle


@Composable
fun PokemonDetailsScreen(
    viewModel: PokemonDetailsViewModel = hiltViewModel(),
    name: String
) {
    LaunchedEffect(Unit){
        viewModel.getPokemonInfo(name = name)
    }
//    var wieight:Double = (viewModel.pokemoninfo.weight)/10
    Column {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
                .fillMaxWidth(),
        )
            {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement  = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "Pokedex",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 50.dp)
                )
                Text(
                    text = "#00${viewModel.pokemoninfo.id}",
                    color = Color.Black,
                    modifier =Modifier.padding(end = 10.dp)
                )
            }
                 AsyncImage(
                        model = viewModel.pokemoninfo.sprites.front_default,
                        contentDescription = "front_default",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxSize()
                            .size(320.dp)
                 )
        }
        Column(
            modifier = Modifier
                .weight(2f)
                .background(Color.White)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
                Text(
                    text = "${viewModel.pokemoninfo.name}",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 15.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                viewModel.pokemoninfo.types.forEach{
                    Text(
                        text = "${it.type.name}",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(10.dp)
                            .border(1.dp, Color.Black, RoundedCornerShape(40))
                            .width(100.dp)
                            .height(30.dp)
                            .background(
                                color = viewModel.getColor(it.type.name), RoundedCornerShape(40)
                            )
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Text(
                        text = "${viewModel.pokemoninfo.weight} KG",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )

                }

                Spacer(modifier = Modifier.padding(30.dp))
                Text(
                    text = "${viewModel.pokemoninfo.height} M",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
//                        .padding(start = 10.dp)
                )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "Weight",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(30.dp))
                Text(
                    text = "Height",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
//                        .padding(start = 10.dp)
                )
            }
        }
    }
}

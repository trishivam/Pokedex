package com.shivam.pokedex.screen.pokedexScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlin.math.round


@Composable
fun PokemonDetailsScreen(
    viewModel: PokemonDetailsViewModel = hiltViewModel(),
    name: String
) {
            Column {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.Cyan)
                        .fillMaxWidth(),
//                    Arrangement.SpaceAround,

                ){
                    Row(

                    ) {
                        Text(
                            text = "Pokedex",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 15.dp, start = 55.dp)
                        )
                        Text(
                            text = "#00${viewModel.pokemoninfo.id}",
                            color = Color.White,
//                            modifier = Modifier.align(Alignment.)
                        )
                    }
                }
                Row(

                    modifier = Modifier
                        .weight(2f)
                        .background(Color.Black)
                        .fillMaxWidth()
                ){

                }
            }
        }

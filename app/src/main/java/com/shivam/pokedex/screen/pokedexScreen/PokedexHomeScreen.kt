package com.shivam.pokedex.screen.pokedexScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.shivam.pokedex.R
import com.shivam.pokedex.data.Sprites

@Composable
fun PokedexHomeScreen(
    viewModel: PokedexViewModel = hiltViewModel(),
    onCardClicked:(String) -> Unit,
) {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .background(Color(135, 206, 250))
                .fillMaxWidth()
        ) {
            Text(
                text = "Pokedex" ,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(viewModel.loading) {
                Image(
                    painter = painterResource(R.drawable.animation___1706637250790),
                    contentDescription = "Loading"
                )
            }
            else if(viewModel.errorMessage.isNotEmpty()) {
                Text(text = viewModel.errorMessage)
                Button(onClick = {  }) {
                    Text(text = "Retry")
                }
            }
            else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    items(viewModel.pokemondataList) {
                            pokemon->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                                .background(Color.Cyan)
                                .clickable(onClick = { onCardClicked(pokemon.name) }),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 4.dp
                            )
                        ) {
                            if(viewModel.loading) {
                                Image(
                                    painter = painterResource(R.drawable.animation___1706637308035),
                                    contentDescription = "Pokemon Loading"
                                )
                            }
                            else if(viewModel.errorMessage.isNotEmpty()) {
                                Image(painter = painterResource(R.drawable.unloadimage),
                                    contentDescription = "Unload Image"
                                )
                            }
                            else {
                                getPokemonCardContent(pokemon.sprites, pokemon.name)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getPokemonCardContent(
    sprites: Sprites,
    name: String,
) {
    Column(
        modifier = Modifier.background(Color.Cyan)
    ) {
        AsyncImage(
            model = sprites.front_default,
            contentDescription = "front_default",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .size(120.dp)
        )
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            color = Color.Black
        )
    }
}







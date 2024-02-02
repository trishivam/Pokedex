package com.shivam.pokedex.screen.pokedexScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.shivam.pokedex.data.PokemonDataResponse
import com.shivam.pokedex.data.Sprites


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexHomeScreen(
    viewModel: PokedexViewModel = hiltViewModel(),
    onImageClicked:(String) -> Unit,
) {
    var searchPokemon by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.background(Color.White)
    ){
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
            if(viewModel.loading){
                CircularProgressIndicator(
                    color = Color.Blue,
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(Alignment.CenterVertically)
                )
            }
            else if(viewModel.errorMessage.isNotEmpty()){
                Text(text = viewModel.errorMessage)
            }
            else{
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ){
                    items(viewModel.pokemondataList){
                            pokemon->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                                .background(Color.Cyan),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 4.dp
                            )
                        ) {
                            if(viewModel.loading){
                                CircularProgressIndicator(
                                    color = Color.Blue,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .wrapContentHeight(Alignment.CenterVertically)
                                )
                            }
                            else if(viewModel.errorMessage.isNotEmpty()){
                                Text(text = viewModel.errorMessage)
                            }
                            else{
                                getPokemonIconAndName(pokemon.sprites, pokemon.name, onImageClicked)
                            }
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun getPokemonIconAndName(
    sprites: Sprites,
    name: String,
    onImageClicked: (String)-> Unit
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
                .clickable(onClick = { onImageClicked(name) }),
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

//@Composable
//fun TextFields(){
//    Spacer(modifier = Modifier.padding(4.dp))
//    TextField(
//        value = searchPokemon.trim(),
//        onValueChange = { searchPokemon = it },
//        placeholder = { Text( text="Search Pokemon", color = Color.Black) },
//        trailingIcon = { Icon(
//            Icons.Filled.Search,
//            contentDescription = null,
//            modifier = Modifier
//                .height(30.dp)
//                .clickable {
//                    viewModel.getPokemonByName(searchPokemon)
//                }
//        ) },
//        singleLine = true,
//        modifier = Modifier
//            .padding(8.dp,)
//            .fillMaxWidth()
//            .shadow(16.dp)
//            .background(
//                color = Color.White,
//                shape = RoundedCornerShape(20.dp)
//            ),
//        keyboardOptions = KeyboardOptions(
//            imeAction = ImeAction.Done
//        )
//
//    )
//
//}







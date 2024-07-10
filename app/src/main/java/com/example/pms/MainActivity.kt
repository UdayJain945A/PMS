package com.example.pms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pms.ui.theme.PMSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                AppBar()
                setuprecycler()
                bottombuton()

            }

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun AppBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .size(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "PMS", modifier = Modifier.padding(bottom = 5.dp,start = 10.dp),
                fontSize = 20.sp
            )

            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = "icon",
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Preview
@Composable
fun setuprecycler(){
    val data= listOf(
        Mydata(R.drawable.baseline_folder_24,"Jetpack Compose",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Android",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Kotlin",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"MVVM",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Firebase",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"kotlin coroutines",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"kotlin Flows",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Android Sdk",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Debugging",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Rest Api",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Gemini Api",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Project pdf",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"KMP",R.drawable.baseline_delete_24 ),
        Mydata(R.drawable.baseline_folder_24,"Git Github",R.drawable.baseline_delete_24 ),

    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.93f)
            .background(Color.White)
          ) {
        items(data.size){
            Listitem(data[it])

        }

    }

}

@Composable
fun Listitem(data:Mydata,modifier: Modifier=Modifier){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = painterResource(id = R.drawable.folder), contentDescription = "icon"
            ,modifier=Modifier.size(50.dp))
        Text(text = data.text)
        
        Spacer(modifier = modifier.size(12.dp))
        Image(painter = painterResource(id = R.drawable.baseline_delete_24), contentDescription ="delete" )

    }
}
@Preview
@Composable
fun bottombuton(){
    var statebutton= remember {
        mutableStateOf(20.dp)
    }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.padding(start =statebutton.value, bottom = 4.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "ADD SUBJECTS")
        }

        Button(onClick = { /*TODO*/ },
        modifier = Modifier.padding(end = 20.dp, bottom = 4.dp),
            shape = RoundedCornerShape(10.dp)
            ) {

            Text(text = "UPLOAD NOTES")
            
        }
    }
}

class Mydata(val icon:Int,val text:String,val icon2:Int)





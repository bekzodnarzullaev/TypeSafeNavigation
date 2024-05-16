package bekzod.narzullaev.typesafenavigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import bekzod.narzullaev.typesafenavigation.ui.theme.TypeSafeNavigationTheme
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

private const val TAG = "MainActivityLOG"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypeSafeNavigationTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenA
                ) {
                    composable<ScreenA> {

                        LaunchedEffect(Unit) {
                            Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(space = 6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(onClick = {
//                                navController.navigate(
//                                    ScreenB(
//                                        name = "Bekzod",
//                                        age = 24
//                                    )
//                                )
                                navController.navigateSingleTop(Home)
//                                Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                            }) {
                                Text(text = "Go to Home")
                            }
                            Button(onClick = {
                                navController.navigateSingleTop(Payment)
                            }) {
                                Text(text = "Go to Payment")
                            }
                            Button(onClick = {
                                navController.navigateSingleTop(Transfer)
                            }) {
                                Text(text = "Go to Transfer")
                            }
                            Button(onClick = {
                                navController.navigateSingleTop(History)
                            }) {
                                Text(text = "Go to History")
                            }
                            Button(onClick = {
                                navController.navigateSingleTop(Service)
                            }) {
                                Text(text = "Go to Service")
                            }

                        }
                    }
                    composable<ScreenB> {
                        val args = it.toRoute<ScreenB>()
                        LaunchedEffect(Unit) {
                            Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "${args.name}, ${args.age} years old")
                        }
                    }
                    composable<ScreenC> {
                        LaunchedEffect(Unit) {
                            Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Screen ${it.destination.route}")
                        }
                    }
                    composable<Home> {
                        LaunchedEffect(Unit) {
                            Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Screen ${it.destination.route}")
                        }
                    }
                    composable<Payment> {
                        LaunchedEffect(Unit) {
                            Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Screen ${it.destination.route}")
                        }
                    }
                    composable<Transfer> {
                        LaunchedEffect(Unit) {
                            Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Screen ${it.destination.route}")
                        }
                    }
                    composable<History> {
                        LaunchedEffect(Unit) {
                            Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Screen ${it.destination.route}")
                        }
                    }
                    composable<Service> {
                        LaunchedEffect(Unit) {
                            Log.d(TAG, "onCreate: ${navController.currentDestination?.route}")
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Screen ${it.destination.route}")
                        }
                    }

                }
            }
        }
    }
}

@Serializable
object ScreenA

@Serializable
data class ScreenB(
    val name: String?,
    val age: Int
)

@Serializable
object ScreenC
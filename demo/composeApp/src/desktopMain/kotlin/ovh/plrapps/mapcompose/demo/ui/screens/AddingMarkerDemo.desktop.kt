package ovh.plrapps.mapcompose.demo.ui.screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import ovh.plrapps.mapcompose.demo.viewmodels.AddingMarkerVM
import ovh.plrapps.mapcompose.demo.ui.MapWithZoomControl

actual object AddingMarkerDemo : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { AddingMarkerVM() }

        MapWithZoomControl(state = screenModel.state) {
            AddingMarkerCommonUi(screenModel)
        }
    }
}
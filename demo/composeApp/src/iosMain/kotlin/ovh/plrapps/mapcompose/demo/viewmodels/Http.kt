package ovh.plrapps.mapcompose.demo.viewmodels

import ovh.plrapps.mapcompose.core.TileStreamProvider
import ovh.plrapps.mapcompose.demo.utils.getKtorClient
import ovh.plrapps.mapcompose.demo.utils.getStream

actual fun makeHttpTileStreamProvider(): TileStreamProvider {
    // TODO: use a blocking http client. MapCompose already switches context when calling the provided TileStreamProvider,
    // so there is no need for an asynchronous http client such as Ktor.
    val httpClient = getKtorClient()
    return TileStreamProvider { row, col, zoomLvl ->
        try {
            getStream(
                httpClient,
                path = "https://raw.githubusercontent.com/p-lr/MapCompose/master/demo/src/main/assets/tiles/mont_blanc/$zoomLvl/$row/$col.jpg"
            )
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
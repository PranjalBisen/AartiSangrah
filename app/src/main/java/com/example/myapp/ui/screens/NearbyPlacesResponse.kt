import com.google.android.gms.maps.model.LatLng

data class NearbyPlacesResponse(val results: List<PlaceResult>)

data class PlaceResult(val name: String?, val geometry: Geometry?)

data class Geometry(val location: LocationLatLng?)

data class LocationLatLng(val lat: Double, val lng: Double) {
    fun toLatLng() = LatLng(lat, lng)
}

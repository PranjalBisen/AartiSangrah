import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesService {
    @GET("maps/api/place/nearbysearch/json")
    suspend fun getNearbyTemples(
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String,
        @Query("key") apiKey: String
    ): NearbyPlacesResponse
}

package com.amber.random.datapoliceuk.api;

import com.amber.random.datapoliceuk.model.AvailableDataSet;
import com.amber.random.datapoliceuk.model.crime.Crime;
import com.amber.random.datapoliceuk.model.crime.CrimeOutcome;
import com.amber.random.datapoliceuk.model.crime.CrimesCategory;
import com.amber.random.datapoliceuk.model.crime.LastUpdated;
import com.amber.random.datapoliceuk.model.force.ForceItem;
import com.amber.random.datapoliceuk.model.force.SeniorOfficerItem;
import com.amber.random.datapoliceuk.model.force.SpecificForceItem;
import com.amber.random.datapoliceuk.model.neighbourhood.Coordinate;
import com.amber.random.datapoliceuk.model.neighbourhood.NeighbourhoodForce;
import com.amber.random.datapoliceuk.model.neighbourhood.NeighbourhoodLocate;
import com.amber.random.datapoliceuk.model.neighbourhood.NeighbourhoodPriority;
import com.amber.random.datapoliceuk.model.neighbourhood.NeighbourhoodTeam;
import com.amber.random.datapoliceuk.model.neighbourhood.SpecificNeighbourhood;
import com.amber.random.datapoliceuk.model.stop_and_search.StopAndSearches;

import java.util.Collection;
import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BackendServiceApi {

    //region availability

    @GET("crimes-street-tables-dates")
    Flowable<List<AvailableDataSet>> getAvailability();

    //endregion availability

    //region forces

    @GET("forces")
    Flowable<List<ForceItem>> getAllForces();

    @GET("forces")
    Flowable<SpecificForceItem> getSpecificForce(@Body String forceId);

    @GET("forces/{forceId}/people")
    Flowable<List<SeniorOfficerItem>> getAllSpecificForcePeople(@Path("forceId") String forceId);

    //endregion forces

    //region crimes

    @GET("crime-last-updated")
    Flowable<List<LastUpdated>> getLastUpdatedCrime();

    //Returns a list of valid categories for a given data set date.
    @GET("crime-categories")
    Flowable<List<CrimesCategory>> getAllCrimesCategories(@Path("date") String date);

    @GET("crimes-at-location")
    Flowable<List<Crime>> getCrimesAtLocationId(@Query("date") String date, @Query("locarion_id") Integer locationId);

    @GET("crimes-at-location")
    Flowable<List<Crime>> getCrimesAtLocation(@Query("date") String date, @Query("lat") double lat, @Query("lng") double lng);

    @GET("crimes-street")
    Flowable<List<Crime>> getStreetCrimes(@Query("lat") String lat, @Query("lng") String lng, @Query("date") String date_id);

    @GET("crimes-street")
    Flowable<List<Crime>> getStreetCrimes(@Query("poly") String poly, @Query("date") String date_id);

    @GET("crimes-street")
    Flowable<List<Crime>> getStreetWithoutLocation(@Query("category") String categoryName, @Query("force") String forceId, @Query("date") String date_id);

    @GET("outcomes-at-location")
    Flowable<List<CrimeOutcome>> getOutcomesAtLocation(@Query("date") String date, @Query("location_id") String locationId);

    @GET("outcomes-at-location")
    Flowable<List<CrimeOutcome>> getOutcomesAtLocation(@Query("date") String date, @Query("lat") double lat, @Query("lng") double lng);

    @GET("outcomes-at-location")
    Flowable<List<CrimeOutcome>> getOutcomesAtCustomArea(@Query("date") String date, @Query("poly") String poly);

    //endregion crimes

    //region neighbourhoods

    @GET("{forceId}/neighbourhoods")
    Flowable<List<NeighbourhoodForce>> getForceNeighbourhoods(@Path("forceId") String forceId);

    @GET("{forceId}/{neighbourhoodId}")
    Flowable<SpecificNeighbourhood> getSpecificNeighbourhood(@Path("forceId") String forceId, @Path("neighbourhoodId") String neighbourhoodId);

    @GET("locate-neighbourhood")
    Flowable<NeighbourhoodLocate> getLocateNeighbourhood(@Query("q") String latAndLong);

    @GET("{forceId}/{neighbourhoodId}/boundary")
    Flowable<List<Coordinate>> getNeighbourhoodBoundary(@Path("forceId") String forceId, @Path("neighbourhoodId") String neighbourhoodId);

    @GET("{forceId}/{neighbourhoodId}/people")
    Flowable<List<NeighbourhoodTeam>> getNeighbourhoodTeam(@Path("forceId") String forceId, @Path("neighbourhoodId") String neighbourhoodId);

    @GET("{forceId}/{neighbourhoodId}/priorities")
    Flowable<List<NeighbourhoodPriority>> getNeighbourhoodPriorities(@Path("forceId") String forceId, @Path("neighbourhoodId") String neighbourhoodId);
    //endregion  neighbourhoods

    //region Stop and search

    @GET("stops-force")
    Flowable<List<StopAndSearches>> getReportedStopAndSearches(@Query("force") String forceId, @Query("date") String date);

    @GET("stops-force")
    Flowable<List<StopAndSearches>> getReportedStopAndSearches(@Query("force") String forceId);

    @GET("stops-no-location")
    Flowable<List<StopAndSearches>> getReportedStopAndSearchesWithoutLocation(@Query("force") String forceId, @Query("date") String date);

    @GET("stops-no-location")
    Flowable<List<StopAndSearches>> getReportedStopAndSearchesWithoutLocation(@Query("force") String forceId);

    @GET("stops-at-location")
    Flowable<List<StopAndSearches>> getReportedStopAndSearchesByLocation(@Query("location_id") String locationId, @Query("date") String date);

    @GET("stops-at-location")
    Flowable<List<StopAndSearches>> getReportedStopAndSearchesByLocation(@Query("location_id") String location);

    @GET("stops-street")
    Flowable<List<StopAndSearches>> getReportedStopAndSearchesBySpecificPoint(@Query("lat") String lat, @Query("lng") String lng, @Query("date") String date);

    @GET("stops-street")
    Flowable<List<StopAndSearches>> getReportedStopAndSearchesBySpecificPoint(@Query("lat") String lat, @Query("lng") String lng);

    @GET("stops-street")
    Flowable<List<StopAndSearches>> getReportedStopAndSearchesByCustomArea(@Query("poly") String poly);

    @GET("stops-street")
    Flowable<List<StopAndSearches>> getReportedStopAndSearchesByCustomArea(@Query("poly") String poly, @Path("date") String date);

    //endregion Stop and search

}

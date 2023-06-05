package com.contactkaran.mywordsdictionary.data.remote

import com.contactkaran.mywordsdictionary.data.remote.dto.WordDataDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApiService {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordData(
        @Path("word") word: String
    ) : List<WordDataDto>

}
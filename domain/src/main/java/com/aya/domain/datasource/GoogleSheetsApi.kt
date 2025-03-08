package com.aya.data.datasource

import com.aya.domain.model.Bug

interface GoogleSheetsApi {
    suspend fun uploadBug(bug: Bug): Boolean
    suspend fun fetchBugs(): List<Bug>

    /*
        domain : https://sheets.googleapis.com/
    *   @POST("v4/spreadsheets/{spreadsheetId}/values/{range}:append")
    suspend fun uploadBug(
        @Path("spreadsheetId") spreadsheetId: String,
        @Path("range") range: String,
        @Body requestBody: BugReport
    ): Response<Unit>*/
}
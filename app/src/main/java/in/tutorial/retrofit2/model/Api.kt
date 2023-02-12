package `in`.tutorial.retrofit2.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import java.util.UUID

interface Api {

    @Headers(
        "Accept: application/json",
        "auth:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7ImlkIjoiNjcyNmIxZjAtMmExMS0xMWVkLWJhMjQtNTI1NDAwMDI0MjcxIiwibmFtZSI6Imdyb290IiwiZGlzcGxheU5hbWUiOiJhYmhpZ3VydTIiLCJpZGVudGl0eSI6IiIsImVtYWlsIjoiYWJoaW5hdmd1cnUyQGdtYWlsLmNvbSIsInN1cGVydmlzb3IiOjEsImFjdGl2ZSI6MSwidHJsIjpbXX0sImlhdCI6MTY3Mzk3MzA2NywiZXhwIjoxNjc2NTY1MDY3fQ.Cc3lvsBFH_MXb6pbryUMSng4WfckIaenUr5HilT6xJ0"
    )
    @GET("item/{id}")
    fun getItem(@Path("id") resourceId:UUID): Call<Item>

    @Headers(
        "Accept: application/json",
        "auth:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7ImlkIjoiNjcyNmIxZjAtMmExMS0xMWVkLWJhMjQtNTI1NDAwMDI0MjcxIiwibmFtZSI6Imdyb290IiwiZGlzcGxheU5hbWUiOiJhYmhpZ3VydTIiLCJpZGVudGl0eSI6IiIsImVtYWlsIjoiYWJoaW5hdmd1cnUyQGdtYWlsLmNvbSIsInN1cGVydmlzb3IiOjEsImFjdGl2ZSI6MSwidHJsIjpbXX0sImlhdCI6MTY3Mzk3MzA2NywiZXhwIjoxNjc2NTY1MDY3fQ.Cc3lvsBFH_MXb6pbryUMSng4WfckIaenUr5HilT6xJ0"
    )
    @GET("item")
    fun getItemsList():Call<ItemsList>
}
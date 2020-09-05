package com.example.praveenpayasimachinetest.utils


import com.example.praveenpayasimachinetest.R
import java.util.regex.Pattern

object Validator {

    private val EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    private const val MIN_NAME_LENGTH = 2

    fun validateAddUserFields(name: String?, email: String?, id: String?): List<Validation> =
        ArrayList<Validation>().apply {
            when {
                name.isNullOrBlank() ->
                    add(Validation(Validation.Field.NAME, Resource.error(R.string.name_field_empty)))
                name.length < MIN_NAME_LENGTH ->
                    add(Validation(Validation.Field.NAME, Resource.error(R.string.name_field_small_length)))
                else ->
                    add(Validation(Validation.Field.NAME, Resource.success()))
            }
            when {
                id.isNullOrBlank() ->
                    add(Validation(Validation.Field.ID, Resource.error(R.string.id_field_empty)))
                id.length < 2 ->
                    add(Validation(Validation.Field.ID, Resource.error(R.string.id_field_small_length)))
                else -> add(Validation(Validation.Field.ID, Resource.success()))
            }
            when {
                email.isNullOrBlank() ->
                    add(Validation(Validation.Field.EMAIL, Resource.error(R.string.email_field_empty)))
                !EMAIL_ADDRESS.matcher(email).matches() ->
                    add(Validation(Validation.Field.EMAIL, Resource.error(R.string.email_field_invalid)))
                else ->
                    add(Validation(Validation.Field.EMAIL, Resource.success()))
            }

        }
}

data class Validation(val field: Field, val resource: Resource<Int>) {

    enum class Field {
        ID,
        EMAIL,
        NAME
    }
}

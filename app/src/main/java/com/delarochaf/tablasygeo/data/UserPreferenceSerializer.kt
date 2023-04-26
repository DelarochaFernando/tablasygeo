package com.delarochaf.tablasygeo.data

import androidx.datastore.core.Serializer
import java.io.InputStream
import java.io.OutputStream

//ProtoDatastore tutorial
//https://medium.com/tech-takeaways/how-to-use-androids-proto-datastore-with-kotlin-support-8e4f80f1d6d

object UserPreferenceSerializer : Serializer<UserPreferences>{
    override val defaultValue: UserPreferences
        get() = TODO("Not yet implemented")

    override suspend fun readFrom(input: InputStream): UserPreferences {
        TODO("Not yet implemented")
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        TODO("Not yet implemented")
    }

}
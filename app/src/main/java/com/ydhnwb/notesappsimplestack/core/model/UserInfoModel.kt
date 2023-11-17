package com.ydhnwb.notesappsimplestack.core.model


data class UserInfoModel (
    val id: String,
    val name: String,
    val bio: String
){
    override fun toString(): String {
        return """{"id":$id, "name":$name, "bio": $bio}"""
    }
}
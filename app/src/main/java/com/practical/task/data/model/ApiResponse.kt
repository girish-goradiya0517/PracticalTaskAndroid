package com.practical.task.data.model

import com.google.gson.annotations.SerializedName


data class DiscoveryResponse(
    val success: Boolean,
    @SerializedName("api_log_id")
    val apiLogId: Long,
    @SerializedName("request_uuid")
    val requestUuid: String,
    val generated: String,
    val page: Page,
)

data class Page(
    val id: Long,
    val name: String,
    val elements: List<Element>,
    @SerializedName("pill_filters")
    val pillFilters: List<PillFilter>,
)

data class Element(
    val id: Long,
    @SerializedName("element_type")
    val elementType: String,
    val header: String,
    val subheader: String,
    val sku: String?,
    @SerializedName("media_data")
    val mediaData: MediaData?,
    @SerializedName("mobile_image_url")
    val mobileImageUrl: String?,
    @SerializedName("tablet_image_url")
    val tabletImageUrl: String?,
    @SerializedName("variant_types")
    val variantTypes: List<String>?,
    @SerializedName("component_items")
    val componentItems: List<ComponentItem>?,
    val style: String?,
)

data class MediaData(
    val authors: List<Author>,
    @SerializedName("book_id")
    val bookId: Long,
    val categories: List<Category>,
    val cover: Cover,
    val description: String,
    @SerializedName("media_id")
    val mediaId: Long,
    @SerializedName("product_properties")
    val productProperties: List<ProductProperty>,
    val title: String,
    val topics: List<Any?>,
    val ebook: Ebook,
    val subtitles: List<Subtitle>,
    val languages: List<Language>,
    val publisher: Publisher,
    val genres: List<Any?>,
)

data class Author(
    val id: Long,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
)

data class Category(
    val name: String,
    val id: Long,
    val description: String,
)

data class Cover(
    @SerializedName("full_url")
    val fullUrl: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("detail_url")
    val detailUrl: String,
    @SerializedName("listing_url")
    val listingUrl: String,
)

data class ProductProperty(
    @SerializedName("property_id")
    val propertyId: Long,
    val id: Long,
    @SerializedName("property_name")
    val propertyName: String,
    val value: String,
)

data class Ebook(
    val properties: List<Any?>,
    @SerializedName("subscription_plan_ids")
    val subscriptionPlanIds: List<String>,
    @SerializedName("book_id")
    val bookId: Long,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("media_id")
    val mediaId: Long,
    @SerializedName("pretty_price")
    val prettyPrice: String,
    val price: Double,
    @SerializedName("sample_available")
    val sampleAvailable: Boolean,
    val sku: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val version: Long,
    @SerializedName("release_date")
    val releaseDate: Any?,
    val scriptures: Boolean,
    @SerializedName("view_mode")
    val viewMode: String,
    @SerializedName("user_info")
    val userInfo: UserInfo,
)

data class UserInfo(
    @SerializedName("in_library")
    val inLibrary: Boolean,
    val purchased: Boolean,
    val subscribed: Boolean,
    val subscribable: Boolean,
    @SerializedName("expires_at")
    val expiresAt: String,
    val sample: Boolean,
    @SerializedName("last_position")
    val lastPosition: String,
    val favorite: Boolean,
    @SerializedName("can_buy_now")
    val canBuyNow: Boolean,
    val completed: Boolean,
    val archived: Boolean,
)

data class Subtitle(
    val type: String,
    val value: String,
)

data class Language(
    val name: String,
    val iso: String,
)

data class Publisher(
    val id: String,
    val name: String,
)

data class ComponentItem(
    val id: Long,
    val sku: String,
    @SerializedName("variant_type")
    val variantType: String,
    @SerializedName("media_data")
    val mediaData: MediaData2,
    @SerializedName("image_url")
    val imageUrl: String?,
)

data class MediaData2(
    val authors: List<Author2>,
    @SerializedName("book_id")
    val bookId: Long,
    val categories: List<Category2>,
    val cover: Cover2,
    val description: String,
    @SerializedName("media_id")
    val mediaId: Long,
    @SerializedName("product_properties")
    val productProperties: List<ProductProperty2>,
    val title: String,
    val topics: List<Topic>,
    val ebook: Ebook2,
    val languages: List<Language2>,
    val publisher: Publisher2,
    val genres: List<Any?>,
    @SerializedName("available_variants")
    val availableVariants: AvailableVariants?,
    val subtitles: List<Subtitle2>?,
)

data class Author2(
    val id: Long,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
)

data class Category2(
    val name: String,
    val id: Long,
    val description: String,
)

data class Cover2(
    @SerializedName("full_url")
    val fullUrl: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("detail_url")
    val detailUrl: String,
    @SerializedName("listing_url")
    val listingUrl: String,
)

data class ProductProperty2(
    @SerializedName("property_id")
    val propertyId: Long,
    val id: Long,
    @SerializedName("property_name")
    val propertyName: String,
    val value: String,
)

data class Topic(
    val name: String,
    val id: Long,
    val description: String,
)

data class Ebook2(
    val properties: List<Property>,
    @SerializedName("subscription_plan_ids")
    val subscriptionPlanIds: List<String>,
    @SerializedName("book_id")
    val bookId: Long,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("media_id")
    val mediaId: Long,
    @SerializedName("pretty_price")
    val prettyPrice: String,
    val price: Double,
    @SerializedName("sample_available")
    val sampleAvailable: Boolean,
    val sku: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val version: Long,
    val scriptures: Boolean,
    @SerializedName("view_mode")
    val viewMode: String,
    @SerializedName("user_info")
    val userInfo: UserInfo2,
    @SerializedName("release_date")
    val releaseDate: Any?,
)

data class Property(
    @SerializedName("property_id")
    val propertyId: Long,
    val id: Long,
    @SerializedName("property_name")
    val propertyName: String,
    val value: String,
)

data class UserInfo2(
    @SerializedName("in_library")
    val inLibrary: Boolean,
    val purchased: Boolean,
    val subscribed: Boolean,
    val subscribable: Boolean,
    @SerializedName("expires_at")
    val expiresAt: String,
    val sample: Boolean,
    @SerializedName("last_position")
    val lastPosition: String,
    val favorite: Boolean,
    @SerializedName("can_buy_now")
    val canBuyNow: Boolean,
    val completed: Boolean,
    val archived: Boolean,
)

data class Language2(
    val name: String,
    val iso: String,
)

data class Publisher2(
    val id: String,
    val name: String,
)

data class AvailableVariants(
    val ebook: Ebook3,
    val audiobook: Audiobook,
)

data class Ebook3(
    val sku: String,
    val url: String,
)

data class Audiobook(
    val sku: String,
    val url: String,
)

data class Subtitle2(
    val type: String,
    val value: String,
)

data class PillFilter(
    val id: Long,
    val name: String,
    @SerializedName("page_id")
    val pageId: Long,
)

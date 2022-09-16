import com.google.gson.annotations.SerializedName


data class ProfileListResponseModel(

    @SerializedName("invites")
    var invites: Invites? = Invites(),

    @SerializedName("likes")
    var likes: Likes? = Likes(),

    )

data class Invites(

    @SerializedName("profiles")
    var profiles: ArrayList<Profiles> = arrayListOf(),

    @SerializedName("totalPages")
    var totalPages: Int? = null,

    @SerializedName("pending_invitations_count")
    var pendingInvitationsCount: Int? = null,

    )

data class Likes(

    @SerializedName("profiles")
    var likesProfiles: ArrayList<LikesProfiles> = arrayListOf(),

    @SerializedName("can_see_profile")
    var canSeeProfile: Boolean? = null,

    @SerializedName("likes_received_count")
    var likesReceivedCount: Int? = null,

    )

data class LikesProfiles(

    @SerializedName("first_name")
    var firstName: String? = null,

    @SerializedName("avatar")
    var avatar: String? = null,

    )


data class Profiles(

    @SerializedName("general_information")
    var generalInformation: GeneralInformation? = GeneralInformation(),

    @SerializedName("approved_time")
    var approvedTime: Double? = null,

    @SerializedName("disapproved_time")
    var disapprovedTime: Double? = null,

    @SerializedName("photos")
    var photos: ArrayList<Photos> = arrayListOf(),

    @SerializedName("user_interests")
    var userInterests: ArrayList<String> = arrayListOf(),

    @SerializedName("work")
    var work: Work? = Work(),

    @SerializedName("preferences")
    var preferences: ArrayList<Preferences> = arrayListOf(),

    @SerializedName("instagram_images")
    var instagramImages: String? = null,

    @SerializedName("last_seen_window")
    var lastSeenWindow: String? = null,

    @SerializedName("is_facebook_data_fetched")
    var isFacebookDataFetched: Boolean? = null,

    @SerializedName("icebreakers")
    var icebreakers: String? = null,

    @SerializedName("story")
    var story: String? = null,
    @SerializedName("meetup")
    var meetup: String? = null,

    @SerializedName("verification_status")
    var verificationStatus: String? = null,

    @SerializedName("has_active_subscription")
    var hasActiveSubscription: Boolean? = null,

    @SerializedName("show_concierge_badge")
    var showConciergeBadge: Boolean? = null,

    @SerializedName("lat")
    var lat: Double? = null,

    @SerializedName("lng")
    var lng: Double? = null,

    @SerializedName("last_seen")
    var lastSeen: String? = null,

    @SerializedName("online_code")
    var onlineCode: Int? = null,

    @SerializedName("profile_data_list")
    var profileDataList: ArrayList<ProfileDataList> = arrayListOf(),

    )

data class GeneralInformation(

    @SerializedName("date_of_birth")
    var dateOfBirth: String? = null,

    @SerializedName("date_of_birth_v1")
    var dateOfBirthV1: String? = null,

    @SerializedName("location")
    var location: Location? = Location(),

    @SerializedName("drinking_v1")
    var drinking: Drinking? = Drinking(),

    @SerializedName("first_name")
    var firstName: String? = null,

    @SerializedName("gender")
    var gender: String? = null,

    @SerializedName("marital_status_v1")
    var maritalStatus: MaritalStatus? = MaritalStatus(),

    @SerializedName("ref_id")
    var refId: String? = null,

    @SerializedName("smoking_v1")
    var smoking: Smoking? = Smoking(),

    @SerializedName("sun_sign_v1")
    var sunSign: SunSign? = SunSign(),

    @SerializedName("mother_tongue")
    var motherTongue: MotherTongue? = MotherTongue(),

    @SerializedName("faith")
    var faith: Faith? = Faith(),

    @SerializedName("height")
    var height: Int? = null,

    @SerializedName("cast")
    var cast: String? = null,

    @SerializedName("kid")
    var kid: String? = null,

    @SerializedName("diet")
    var diet: String? = null,

    @SerializedName("politics")
    var politics: String? = null,

    @SerializedName("pet")
    var pet: String? = null,

    @SerializedName("settle")
    var settle: String? = null,

    @SerializedName("mbti")
    var mbti: String? = null,

    @SerializedName("age")
    var age: Int? = null,

    )

data class SunSign(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,

    )

data class Drinking(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("name_alias")
    var nameAlias: String? = null,

    )

data class MaritalStatus(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("preference_only")
    var preferenceOnly: Boolean? = null,

    )

data class Smoking(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("name_alias")
    var nameAlias: String? = null,

    )

data class MotherTongue(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    )

data class Faith(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    )

data class Photos(

    @SerializedName("photo")
    var photo: String? = null,

    @SerializedName("photo_id")
    var photoId: Int? = null,

    @SerializedName("selected")
    var selected: Boolean? = null,

    @SerializedName("status")
    var status: String? = null,

    )

data class Work(

    @SerializedName("industry_v1")
    var industryV1: Industry? = Industry(),

    @SerializedName("monthly_income_v1")
    var monthlyIncome: String? = null,

    @SerializedName("experience_v1")
    var experienceV1: Experience? = Experience(),

    @SerializedName("highest_qualification_v1")
    var highestQualification: HighestQualification? = HighestQualification(),

    @SerializedName("field_of_study_v1")
    var fieldOfStudy: FieldOfStudy? = FieldOfStudy(),

    )

data class Industry(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("preference_only")
    var preferenceOnly: Boolean? = null,

    )

data class Experience(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("name_alias")
    var nameAlias: String? = null,

    )

data class HighestQualification(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("preference_only")
    var preferenceOnly: Boolean? = null,

    )

data class FieldOfStudy(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    )

data class Preferences(

    @SerializedName("answer_id")
    var answerId: Int? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("value")
    var value: Int? = null,

    @SerializedName("preference_question")
    var preferenceQuestion: PreferenceQuestion? = PreferenceQuestion(),

    )

data class ProfileDataList(

    @SerializedName("question")
    var question: String? = null,

    @SerializedName("preferences")
    var profileDataPreferences: ArrayList<ProfileDataPreferences> = arrayListOf(),

    @SerializedName("invitation_type")
    var invitationType: String? = null,

    )

data class ProfileDataPreferences(

    @SerializedName("answer_id")
    var answerId: Int? = null,

    @SerializedName("answer")
    var answer: String? = null,

    @SerializedName("first_choice")
    var firstChoice: String? = null,

    @SerializedName("second_choice")
    var secondChoice: String? = null,

    )

data class PreferenceQuestion(

    @SerializedName("first_choice")
    var firstChoice: String? = null,

    @SerializedName("second_choice")
    var secondChoice: String? = null,

    )

data class Location(

    @SerializedName("summary")
    var summary: String? = null,
    @SerializedName("full")
    var full: String? = null,

    )

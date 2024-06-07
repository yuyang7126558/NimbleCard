import android.view.ViewGroup
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

/**
 * Created by colin.yu on 2024/5/27
 *
 * @author colin.yu@bytedance.com
 */

data class RootJson(
    val version: String,  // 1.0\2.0\
    val templates: List<Template>
)

/**
 * Template
 *
 * @constructor Create empty Template
 * @property type, define card type
 * @property style, define which layout would be used to draw
 * @property components,the component which used be assem
 * @property abilities, container ability
 */
data class Template(
    @SerializedName("type")
    val type: Int,

    @SerializedName("style")
    val style: Style,

    @SerializedName("components")
    val components: List<Component>,

    @SerializedName("abilitys")
    val abilities: List<Ability>?
)

/**
 * Style
 *
 * @constructor Create empty Style
 * @property layout
 */
data class Style(
    @SerializedName("layout")
    val layout: String,

    @SerializedName("subStyle")
    val subStyle: JsonObject?
)

/**
 * layout tag
 *
 * @constructor Create empty Component tag
 * @property tag
 */
enum class NimbleLayout(val tag: String) {
    LINERALAYOUT("linearlayout"),
    RELATIVELAYOUT("relativelayout"),
}

data class Component(
    @SerializedName("component_tag")
    val tag: String,
    val parentView: ViewGroup
)

data class Ability(
    @SerializedName("ability_tag")
    val abilityTag: String,
    val action: Int // 0\1\2\3
)

/**
 * the component in search & tako
 *
 * @constructor Create empty Component tag
 * @property tag
 */
enum class ComponentTag(val tag: String) {
    TEXT("text"),
    IMAGE("image"),
    VIDEO_LIST("video_list"),
    BIG_VIDEO("big_video")
}

/**
 * Ability in Search & tako
 *
 * @constructor Create empty Ability tag
 * @property tag
 */
enum class AbilityTag(val tag: String) {
    AUTO_PLAY("auto_play"),
}
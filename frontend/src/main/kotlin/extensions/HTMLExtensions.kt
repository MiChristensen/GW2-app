package extensions

import kotlinx.html.Tag
import org.intellij.lang.annotations.Language

var Tag.`_` : String
    get() = throw UnsupportedOperationException("This property can't be read")
    set(@Language("HyperScript") value) {
        attributes["_"] = value
    }
package gauc.v338

class DefaultChannel extends Channel {

    static constraints = {
    }

    def beforeValidate() {
        if (!name) {
            name = 'General'
        }
    }
}

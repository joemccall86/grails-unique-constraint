package gauc.v338

abstract class Channel {

    String name

    static constraints = {
        name size: 1..80, unique: true
    }
}

package gauc.v338

abstract class Channel {

    String name

    static belongsTo = [organization: Organization]

    static constraints = {
        name size: 1..80, unique: 'organization'
    }
}

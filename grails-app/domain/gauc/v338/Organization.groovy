package gauc.v338

class Organization {

    String name
    DefaultChannel defaultChannel = new DefaultChannel()

    static hasOne = [defaultChannel: DefaultChannel]

    static constraints = {
    }
}

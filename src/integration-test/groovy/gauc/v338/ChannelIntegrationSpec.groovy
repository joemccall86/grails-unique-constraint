package gauc.v338

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class ChannelIntegrationSpec extends Specification {

    void "test something"() {
        given: 'an existing channel'
        def defaultChannel = new DefaultChannel(name: 'General').save(failOnError: true)

        when: 'a new channel with the same name is created'
        def listChannel = new ListChannel(name: defaultChannel.name)

        then:
        !listChannel.validate()
        listChannel.hasErrors()
        listChannel.errors.getFieldError('name').code == 'unique'
    }
}

package gauc.v3213

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class ChannelIntegrationSpec extends Specification {

    void "test something"() {
        given: 'a test organization'
        def testOrg = new Organization(name: 'Test 1').save(failOnError: true)

        and: 'an existing channel'
        def defaultChannel = new DefaultChannel(organization: testOrg, name: 'General').save(failOnError: true)

        when: 'a new channel with the same name is created'
        def listChannel = new ListChannel(name: defaultChannel.name, organization: testOrg)

        then:
        !listChannel.validate()
        listChannel.hasErrors()
        listChannel.errors.getFieldError('name').code == 'unique'
    }
}

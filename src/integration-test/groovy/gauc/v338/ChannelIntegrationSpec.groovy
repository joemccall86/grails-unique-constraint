package gauc.v338

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class ChannelIntegrationSpec extends Specification {

    void "sibling unique validation works"() {
        given: 'a test organization'
        def testOrg = new Organization(name: 'Test 1').save(failOnError: true)

        and: 'an existing channel'
        def defaultChannel = testOrg.defaultChannel

        when: 'a new channel with the same name is created'
        def listChannel = new ListChannel(name: defaultChannel.name, organization: testOrg)

        then:
        !listChannel.validate()
        listChannel.hasErrors()
        listChannel.errors.getFieldError('name').code == 'unique'
    }

    void 'hasOne unique validation works'() {
        given: 'a test organization'
        def testOrg = new Organization(name: 'Test 1').save(failOnError: true)

        and: 'an existing channel'
        def defaultChannel = testOrg.defaultChannel

        when:
        def testOrg2 = new Organization(name: 'Test 2')

        then:
        testOrg2.save(failOnError: true)

    }
}

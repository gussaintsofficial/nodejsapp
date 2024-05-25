job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/gussaintsofficial/nodejsapp.git', 'main') { node ->
            node / gitConfigName('gussaintsofficial')
            node / gitConfigEmail('gussaints@hotmail.es')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs22')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('gussaintsofficial/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

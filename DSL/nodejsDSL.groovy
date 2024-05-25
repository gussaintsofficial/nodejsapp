job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
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
        shell("npm install")
    }
}

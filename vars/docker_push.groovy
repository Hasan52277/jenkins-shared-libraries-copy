def call(String Project, String ImageTag) {
    withCredentials([usernamePassword(
        credentialsId: 'DockerHubCred',
        passwordVariable: 'DOCKER_PASS',
        usernameVariable: 'DOCKER_USER'
    )]) {
        sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
        sh "docker push ${DOCKER_USER}/${Project}:${ImageTag}"
    }
}

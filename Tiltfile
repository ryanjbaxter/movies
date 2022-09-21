SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='my-image-repo.com/movies')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='dev-namespace')

k8s_custom_deploy(
    'movies',
    apply_cmd="tanzu apps workload apply -f ./workload.yaml --debug --live-update" +
        " --local-path " + LOCAL_PATH +
        " --source-image " + SOURCE_IMAGE +
        " --namespace " + NAMESPACE +
        " --yes >/dev/null" +
        " && kubectl get workload movies --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f ./workload.yaml --namespace " + NAMESPACE + " --yes" ,
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
        sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('movies', port_forwards=["8080:8080", "8081:8081", "9005:9005"],
    extra_pod_selectors=[{'serving.knative.dev/service': 'movies'}])
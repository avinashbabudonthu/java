# Upload archives to remote repository like Nexus. Same as mvn deploy
```
uploadArchives {
    repositories.mavenDeployer {

        repository(url: "file:///Users/mccm06/Documents/Temp/Scratch/mytemprepo/"){
            authentication(username: "admin", password: "admin")
        }

        snapshotRepository(url: "file:///Users/mccm06/Documents/Temp/Scratch/mytemprepo/snapshots/"){
            authentication(username: "admin", password: "admin")
        }

    }
}
```
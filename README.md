# my-band

MyBand is a mobile-first web app designed for independent artists to communicate directly with their community. It allows them to create a public profile, share posts, and events.

## WIP

This project is currently under development. At this stage, it is only possible to display the public profile in mobile view.

## Installation

### 1. Clone this repository
```console 
git clone https://github.com/franzk/my-band.git
```

### 2. Start the backend using Docker Compose:
```console 
docker compose up
```

### 3. Start the frontend:  
```console 
pnpm install
```

```console 
pnpm run dev
```

### 3. Create test data

Exemple given :

Profile :  
```console 
curl -X POST http://localhost:8201/api/v1/profile \
-H "Content-Type: application/json" \
-d '{
  "username": "tranxen200",
  "title": "Tranxen 200",
  "slogan": "Glucose Pop Rock",
  "bio": "Tranxen 200 est un groupe français connu pour son style de musique unique, qui combine des éléments de rock, de pop et d\'électro hypocondriaque.",
  "avatarUrl": "/fakedata/tranxen200/tranxen200-logo.png",
  "coverImageUrl": "/fakedata/tranxen200/tranxen200-cover.png",
  "youtubeId": "ZTeqM5gciH8",
  "tags": ["rock", "pop", "hypocondriaque", "sinusoidal"]
}'
```

Posts :  
```console 
curl -X POST http://localhost:8202/api/v1/post \
-H "Content-Type: application/json" \
-d '{
  "profileId": "ID du profile créé précédemment",
  "title": "On a eu une scission !",
  "content": "Nan mais Joël a été complètement glucose ! Brancher un display rack à connexion analogique sur un VSP 800 !",
  "image": {
    "url": "/fakedata/tranxen200/t2.jpg"
  }
}'
```

```console
curl -X POST http://localhost:8202/api/v1/post \
-H "Content-Type: application/json" \
-d '{
  "profileId": "ID du profile créé précédemment",
  "title": "Tranxen 200 au top 50 !",
  "content": "Si tu vois ça, c\'est que tu as bien avancé",
  "image": {
    "url": "/fakedata/tranxen200/t4.jpg"
  }
}'
```

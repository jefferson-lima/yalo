## Building

    docker build -t yalo .
    docker run --rm -p 8080:8080 yalo

## Testing

`curl --location --request GET 'localhost:8080/posts?start=1&size=2'`


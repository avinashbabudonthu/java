interface Point{
    x: number,
    y: number
}

// variable type declaration is called - Inline Annotation
let draw2 = (point: Point) => {
    console.log("point.x = " + point.x)
    console.log("point.y = " + point.y)
}
draw2({
    x: 10, 
    y: 20,
    // name: "jack" // this line will give compilation error
})
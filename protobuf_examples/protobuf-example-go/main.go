package main

import (
	"fmt"
	"example/simplepb"
)

func main() {
	fmt.Println("hello world!")
	doSimple()
}

func doSimple() {
	sm := simple.SimpleMessage(
		Id: 123,
		IsSimple: true,
		Name: "simplest message",
		SampleList: []int32{ 1, 2, 3, 4 },
	)

	fmt.Println(sm)
}

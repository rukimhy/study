for (let i = 0; i < 5; i++) {
    console.log('*'.repeat(i + 1));
}
console.log("=============");

for (let i = 5; i > 0; i--) {
    console.log('*'.repeat(i));
}
console.log("=============");

for (let i = 0; i < 5; i++) {
    console.log('*'.repeat(5 - i));
}
console.log("=============");

for (let i = 1; i <= 9; i = i + 2) {
    console.log('*'.repeat(i));
}
console.log("=============");

for (let i = 9; i >= 1; i = i - 2) {
    console.log('*'.repeat(i));
}
console.log("=============");

for (let i = 5; i > 0; i--) {
    console.log(' '.repeat(5 - i) + '*'.repeat(i));
}
console.log("=============");

for (let i = 1; i <= 5; i++) {
    console.log(' '.repeat(5 - i) + '*'.repeat(i));
}
console.log("=============");

let j = 2;
for (let i = 1; i <= 5; i = i + 2) {
    console.log(' '.repeat(j--) + '*'.repeat(i));
}
j += 2;
for (let i = 3; i > 0; i = i - 2) {
    console.log(' '.repeat(j++) + '*'.repeat(i));
}
console.log("=============");

j = 1;
for (let i = 0; i < 5; i++) {
    console.log(' '.repeat(4 - i) + '*'.repeat(j));
    j += 2;
}
console.log("=============");
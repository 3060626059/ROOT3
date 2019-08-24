// Getters
const getDomElements = () => {
  const hourDisplay = document.getElementById("hour-display");
  const minuteDisplay = document.getElementById("minute-display");
  const dayDisplay = document.getElementById("day-display");
  const monthDisplay = document.getElementById("month-display");
  const dateDisplay = document.getElementById("date-display");
  const hourHand = document.getElementById("hour-hand");
  const minuteHand = document.getElementById("minute-hand");
  const secondHand = document.getElementById("second-hand");

  return {
    hourDisplay,
    minuteDisplay,
    dayDisplay,
    monthDisplay,
    dateDisplay,
    hourHand,
    minuteHand,
    secondHand };

};

let getCurrentTime = () => {
  let date = new Date();
  let time = date.getTime();
  let hours = date.getHours();
  let minutes = date.getMinutes();
  let seconds = date.getSeconds();
  let milliseconds = date.getMilliseconds();

  return {
    date,
    time,
    // Adjust hours to 12 hour clock
    hours: hours > 12 ? hours - 12 : hours,
    minutes,
    seconds,
    milliseconds };

};

// Setters
const setTimeString = timeUnit => {
  // String representations of time numbers
  const timeStrings = {
    0: "",
    1: "一",
    2: "二",
    3: "三",
    4: "四",
    5: "五",
    6: "六",
    7: "七",
    8: "八",
    9: "九",
    10: "十",
    11: "十一",
    12: "十二",
    13: "十三",
    14: "十四",
    15: "十五",
    16: "十六",
    17: "十七",
    18: "十八",
    19: "十九",
    20: "二十",
    30: "三十",
    40: "四十",
    50: "五十",
    60: "六十" };


  if (timeUnit < 20) {
    return `${timeStrings[timeUnit]}`;
  } else {
    let digitOne = timeStrings[Math.floor(timeUnit / 10) * 10];
    let digitTwo = timeStrings[timeUnit % 10] ? timeStrings[timeUnit % 10] : 0;
    if (digitTwo !== 0) {
      return `${digitOne} ${digitTwo}`;
    } else {
      return `${digitOne}`;
    }
  }
};

const setDateDisplay = currentTime => {
  let daySlice = currentTime.toDateString().slice(0, 3);
  let monthSlice = currentTime.toDateString().slice(4, 7);
  let dateSlice = currentTime.toDateString().slice(8, 10);

  return {
    daySlice,
    monthSlice,
    dateSlice };

};

// Rendering
let rotateHand = (timeUnit, factor, hand) => {
  // -90 degress accomodates for initial css layout position
  let position = timeUnit * factor - 90;
  hand.style.transform = `rotate(${position}deg`;
};

let run = () => {
  setInterval(() => {
    let domElements = getDomElements();
    let currentTime = getCurrentTime();
    // Hand values for animation
    // Seconds, minutes, hours reflect 100ms setInterval() iteration
    let seconds =
    (currentTime.seconds * 1000 + currentTime.milliseconds) / 1000;
    let minutes = (currentTime.minutes * 60 + seconds) / 60;
    let hours = (currentTime.hours * 60 + minutes) / 60;

    // Display strings for long-form readout
    let hourString = setTimeString(currentTime.hours);
    let minuteString = setTimeString(currentTime.minutes);
    let dayString = setDateDisplay(currentTime.date).daySlice;
    let monthString = setDateDisplay(currentTime.date).monthSlice;
    let dateString = setDateDisplay(currentTime.date).dateSlice;

    // Populate DOM Elements
    domElements.hourDisplay.innerHTML = `${hourString}`;
    domElements.minuteDisplay.innerHTML = `${minuteString}`;
    domElements.dayDisplay.innerHTML = `${dayString} | `;
    domElements.monthDisplay.innerHTML = `${monthString} | `;
    domElements.dateDisplay.innerHTML = `${dateString}`;

    // Rotate Hands
    rotateHand(seconds, 6, domElements.secondHand);
    rotateHand(minutes, 6, domElements.minuteHand);
    rotateHand(hours, 30, domElements.hourHand);
  }, 100);
};

run();
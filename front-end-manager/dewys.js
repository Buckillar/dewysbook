
let currentPage = 1;
let booksPerPage = 10;

function changeNumber() {
  const newNumber = parseInt(document.getElementById("numberC").value);
  if (!isNaN(newNumber) && newNumber > 0) {
    booksPerPage = newNumber;
    // Fetch data with the updated pagination
    getAllBooks();
  } else {
    alert("Please enter a valid number greater than zero.");
  }
}
async function addBook() {
  var bookId = document.getElementById("bookId").value;
  var title = document.getElementById("title").value;
  var author = document.getElementById("author").value;
  var year = document.getElementById("year").value;

  try {
    const response = await fetch("http://localhost:8080/dewysbook", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        bookId: bookId,
        bookTitle: title,
        bookAuthor: author,
        bookYear: year,
      }),
    });

    const data = await response.text();
    alert(data);
    getAllBooks();
  } catch (error) {
    console.error("Error adding book:", error);
  }
}

function getAllBooks() {
  const start = (currentPage - 1) * booksPerPage;
  const end = start + booksPerPage;

  fetch("http://localhost:8080/dewysbook")
    .then((response) => response.json())
    .then((data) => {
      var table = document.getElementById("bookTable");
      table.innerHTML = "<tr><th>Book ID</th><th>Title</th><th>Author</th><th>Year</th></tr>";

      data.slice(start, end).forEach((book) => {
        var row = table.insertRow();
        row.insertCell(0).innerText = book.bookId;
        row.insertCell(1).innerText = book.bookTitle;
        row.insertCell(2).innerText = book.bookAuthor;
        row.insertCell(3).innerText = book.bookYear;
      });

      updatePageIndicator();
    });
}

function searchBook() {
  var bookId = document.getElementById("seBookId").value;
  fetch("http://localhost:8080/dewysbook/" + bookId)
    .then((response) => response.json())
    .then((data) => {
      if (data != null) {
        var table = document.getElementById("bookTable");
        table.innerHTML =
          "<tr><th>Book ID</th><th>Title</th><th>Author</th><th>Year</th></tr>";

        var row = table.insertRow();
        row.insertCell(0).innerText = data.bookId;
        row.insertCell(1).innerText = data.bookTitle;
        row.insertCell(2).innerText = data.bookAuthor;
        row.insertCell(3).innerText = data.bookYear;
      } else {
        alert("Book not found");
      }
    });
}

async function deleteBook() {
  var bookId = document.getElementById("delBookId").value;

  try {
    const response = await fetch("http://localhost:8080/dewysbook/" + bookId, {
      method: "DELETE",
    });

    const data = await response.text();
    alert(data);
    getAllBooks();
  } catch (error) {
    console.error("Error deleting book:", error);
  }
}

async function editBook() {
  var bookId = document.getElementById("edBookId").value;
  var title = document.getElementById("edTitle").value;
  var author = document.getElementById("edAuthor").value;
  var year = document.getElementById("edYear").value;

  try {
    const response = await fetch("http://localhost:8080/dewysbook/" + bookId, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        bookId: bookId,
        bookTitle: title,
        bookAuthor: author,
        bookYear: year,
      }),
    });

    const data = await response.text();
    alert(data);
    getAllBooks();
  } catch (error) {
    console.error("Error editing book:", error);
  }
}

function previousPage() {
  if (currentPage > 1) {
    currentPage--;
    getAllBooks();
  }
}

function nextPage() {
  currentPage++;
  getAllBooks();
}

function updatePageIndicator() {
  document.getElementById("pageIndicator").innerText = "Page " + currentPage;
}

onload = (event) => {
  getAllBooks();
};

// Tabs Script

function openTab(evt, tabName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
}

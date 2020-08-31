UPDATE Requests
JOIN Apartments ON Apartments.AptID = Requests.AptID
SET Requests.Status = 'Closed'
WHERE Apartments.BuidlingID = 11;
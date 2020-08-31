SELECT Apartments.BuildingID, ISNULL(count(*), 0) as 'Count'
FROM Apartments
JOIN Requests ON Requests.AptID = Apartments.AptID
WHERE Requests.Status = 'Open'
GROUP BY Apartments.BuildingID;
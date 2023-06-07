// AGENTES

document.getElementById('addAgent').addEventListener('click', function(e) {
    e.preventDefault();

    var agentName = document.getElementById('agentName').value;
    var agentAge = document.getElementById('agentAge').value;
    var agentEntryDate = document.getElementById('agentEntryDate').value;
    var agentRank = document.getElementById('agentRank').value;
    var agentRaids = document.getElementById('agentRaids').value;

    var newAgent = {
        name: agentName,
        age: agentAge,
        entryDate: agentEntryDate,
        rank: agentRank,
        raidsParticipated: agentRaids,
    };

    fetch('URL_API/agent', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newAgent),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

document.getElementById('getAgents').addEventListener('click', function(e) {
    e.preventDefault();

    fetch('URL_API/agent')
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

document.getElementById('deleteAgent').addEventListener('click', function(e) {
    e.preventDefault();

    var agentId = document.getElementById('agentId').value;

    fetch(`http://localhost:8080/gabrielapi/agent/${agentId}`, {
        method: 'DELETE',
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

// REDADAS

document.getElementById('addRaid').addEventListener('click', function(e) {
    e.preventDefault();

    var raidExecutionDate = document.getElementById('raidExecutionDate').value;
    var raidStartTime = document.getElementById('raidStartTime').value;
    var raidEndTime = document.getElementById('raidEndTime').value;
    var raidCapturedQuantity = document.getElementById('raidCapturedQuantity').value;

    var newRaid = {
        executionDate: raidExecutionDate,
        startTime: raidStartTime,
        endTime: raidEndTime,
        capturedQuantity: raidCapturedQuantity,
    };

    fetch('http://localhost:8080/gabrielapi/raid', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newRaid),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

document.getElementById('getRaids').addEventListener('click', function(e) {
    e.preventDefault();

    fetch('http://localhost:8080/gabrielapi/raid')
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

document.getElementById('deleteRaid').addEventListener('click', function(e) {
    e.preventDefault();

    var raidId = document.getElementById('raidId').value;

    fetch(`http://localhost:8080/gabrielapi/raid/${raidId}`, {
        method: 'DELETE',
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

// NARCÓTICOS

document.getElementById('addNarcotic').addEventListener('click', function(e) {
    e.preventDefault();

    var narcoticType = document.getElementById('narcoticType').value;
    var narcoticWeight = document.getElementById('narcoticWeight').value;

    var newNarcotic = {
        type: narcoticType,
        weight: narcoticWeight,
    };

    fetch('http://localhost:8080/gabrielapi/narcotic', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newNarcotic),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

document.getElementById('getNarcotics').addEventListener('click', function(e) {
    e.preventDefault();

    fetch('http://localhost:8080/gabrielapi/narcotic')
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

document.getElementById('deleteNarcotic').addEventListener('click', function(e) {
    e.preventDefault();

    var narcoticId = document.getElementById('narcoticId').value;

    fetch(`http://localhost:8080/gabrielapi/narcotic/${narcoticId}`, {
        method: 'DELETE',
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});


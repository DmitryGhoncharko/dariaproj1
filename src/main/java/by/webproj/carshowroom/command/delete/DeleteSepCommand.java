package by.webproj.carshowroom.command.delete;

import by.webproj.carshowroom.command.Command;
import by.webproj.carshowroom.command.CommandRequest;
import by.webproj.carshowroom.command.CommandResponse;
import by.webproj.carshowroom.controller.RequestFactory;
import by.webproj.carshowroom.entity.AdditionEntity;
import by.webproj.carshowroom.entity.SeparaterlyEntity;
import by.webproj.carshowroom.exception.ServiceError;
import by.webproj.carshowroom.model.service.CarDetailsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteSepCommand implements Command {
    private final RequestFactory requestFactory;
    private final CarDetailsService<SeparaterlyEntity> carDetailsService;
    @Override
    public CommandResponse execute(CommandRequest request) throws ServiceError {
        String additionId = request.getParameter("detailId");
        carDetailsService.deleteById(Long.parseLong(additionId));
        return requestFactory.createRedirectResponse("/controller?command=allDetails");
    }
}
import { Datagrid, List, TextField, Create, SimpleForm, TextInput, Edit, EditButton, SelectField, SelectInput, DeleteButton } from "react-admin";



export const ProductList = (props) => (
    <List>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <TextField source="nome" />
            <TextField source="descricao" />
            <TextField source="qualificacao" />
            <TextField source="valorDiaria" />
            <TextField source="cidade.nome" />
            <EditButton basePath="/Administration" />
            <DeleteButton basePath="/Administration"  />
        </Datagrid>
    </List>
);


export const ProductCreate = (props) => (
    <Create>
        <SimpleForm>
            <TextInput source="id" disabled />
            <TextInput source="nome" />
            <TextInput source="descricao" />
            {/* <TextInput source="qualificacao" /> */}
            <TextInput source="valorDiaria" />
            <SelectInput source="cidade.id" choices={[
                { id: '1', name: 'Curitiba' },
                { id: '2', name: 'São Caetano do Sul' },
                { id: '3', name: 'São Luís' },
                { id: '4', name: 'São Paulo' },
                { id: '5', name: 'Sorocaba' },
            ]} />

        </SimpleForm>
    </Create>
);

export const ProductEdit = (props) => (
    <Edit>
        <SimpleForm>
            <TextInput source="id" disabled />
            <TextInput source="nome" />
            <TextInput source="descricao" />
            {/* <TextInput source="qualificacao" /> */}
            <TextInput source="valorDiaria" />
            <SelectInput source="cidade.id" choices={[
                { id: '1', name: 'Curitiba' },
                { id: '2', name: 'São Caetano do Sul' },
                { id: '3', name: 'São Luís' },
                { id: '4', name: 'São Paulo' },
                { id: '5', name: 'Sorocaba' },
            ]} />
        </SimpleForm>
    </Edit>
);



